FROM ubuntu:18.04

ENV DEBIAN_FRONTEND=noninteractive

ENV SDK_VERSION=sdk-tools-linux-3859397 \
    ANDROID_BUILD_TOOLS_VERSION=31.0.0 \
    APPIUM_VERSION=1.22.0 \
    ATD_VERSION=1.2

#=============
# Set WORKDIR
#=============
WORKDIR /root

#===========
# Polyverse
# https://polyverse.io/how-it-works/
#===========
ARG TOKEN=xxx

RUN curl -s https://sh.polyverse.io | sh -s install ${TOKEN}; \
    if [ $? -eq 0 ]; then \
      apt -y update && \
      apt-get -y install --reinstall $(dpkg --get-selections | awk '{print $1}'); \
    fi

ADD docker/configs/x11vnc.pref /etc/apt/preferences.d/

#==================
# General Packages
#------------------
# xterm
#   Terminal emulator
# supervisor
#   Process manager
# socat
#   Port forwarder
#------------------
#  NoVNC Packages
#------------------
# x11vnc
#   VNC server for X display
#       We use package from ubuntu 18.10 to fix crashing issue
# openbox
#   Windows manager
# feh
#   ScreenBackground
# menu
#   Debian menu
# python-numpy
#   Numpy, For faster performance: https://github.com/novnc/websockify/issues/77
# net-tools
#   Netstat
#------------------
#  Video Recording
#------------------
# ffmpeg
#   Video recorder
# jq
#   Sed for JSON data
#------------------
#    KVM Package
# for emulator x86
# https://help.ubuntu.com/community/KVM/Installation
#------------------
# qemu-kvm
# libvirt-bin
# ubuntu-vm-builder
# bridge-utils
#==================


RUN apt-get -qqy update && apt-get -qqy install --no-install-recommends \
    xterm \
    supervisor \
    socat \
    x11vnc \
    openbox \
    feh \
    menu \
    python-numpy \
    net-tools \
    ffmpeg \
    jq \
    qemu-kvm \
    libvirt-bin \
    ubuntu-vm-builder \
    bridge-utils \
    maven \
    openjdk-8-jdk \
    ca-certificates \
    tzdata \
    zip \
    unzip \
    curl \
    wget \
    libqt5webkit5 \
    libgconf-2-4 \
    xvfb \
    gnupg \
    salt-minion \
    vim \
 && apt clean all \
 && rm -rf /var/lib/apt/lists/*

#===============
# Set JAVA_HOME
#===============
ENV JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre" \
    PATH=$PATH:$JAVA_HOME/bin

#=====================
# Install Android SDK
#=====================
ARG ANDROID_PLATFORM_VERSION="android-25"
ENV ANDROID_HOME=/root

RUN wget -O tools.zip https://dl.google.com/android/repository/${SDK_VERSION}.zip && \
    unzip tools.zip && rm tools.zip && \
    chmod a+x -R $ANDROID_HOME && \
    chown -R root:root $ANDROID_HOME

ENV PATH=$PATH:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/bin:/root/tools:/root/tools/bin

# https://askubuntu.com/questions/885658/android-sdk-repositories-cfg-could-not-be-loaded
RUN mkdir -p ~/.android && \
    touch ~/.android/repositories.cfg && \
    echo y | sdkmanager "platform-tools" && \
    echo y | sdkmanager "build-tools;$ANDROID_BUILD_TOOLS_VERSION" && \
    echo y | sdkmanager "platforms;$ANDROID_PLATFORM_VERSION"
ENV PATH=$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/build-tools

#====================================
# Install latest nodejs, npm, appium
# Using this workaround to install Appium -> https://github.com/appium/appium/issues/10020 -> Please remove this workaround asap
#====================================
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash && \
    apt-get -qqy install nodejs && \
    npm install -g appium@${APPIUM_VERSION} --unsafe-perm=true --allow-root && \
    exit 0 && \
    npm cache clean && \
    apt-get remove --purge -y npm && \
    apt-get autoremove --purge -y && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* && \
    apt-get clean

#================================
# APPIUM Test Distribution (ATD)
#================================
RUN wget -nv -O RemoteAppiumManager.jar "https://github.com/AppiumTestDistribution/ATD-Remote/releases/download/${ATD_VERSION}/RemoteAppiumManager-${ATD_VERSION}.jar"

#==================================
# Fix Issue with timezone mismatch
#==================================
ENV TZ="US/Pacific"
RUN echo "${TZ}" > /etc/timezone

#====================================================
# Scripts to run appium and connect to Selenium Grid
#====================================================
COPY entry_point.sh \
     generate_config.sh \
     wireless_connect.sh \
     wireless_autoconnect.sh \
     /root/

RUN chmod +x /root/entry_point.sh && \
    chmod +x /root/generate_config.sh && \
    chmod +x /root/wireless_connect.sh && \
    chmod +x /root/wireless_autoconnect.sh

#========================================
# Run xvfb and appium server
#========================================
CMD /root/wireless_autoconnect.sh && /root/entry_point.sh

#=======
# noVNC
# Use same commit id that docker-selenium uses
# https://github.com/elgalu/docker-selenium/blob/236b861177bd2917d864e52291114b1f5e4540d7/Dockerfile#L412-L413
#=======
ENV NOVNC_SHA="b403cb92fb8de82d04f305b4f14fa978003890d7" \
    WEBSOCKIFY_SHA="558a6439f14b0d85a31145541745e25c255d576b"
RUN  wget -nv -O noVNC.zip "https://github.com/kanaka/noVNC/archive/${NOVNC_SHA}.zip" \
 && unzip -x noVNC.zip \
 && rm noVNC.zip  \
 && mv noVNC-${NOVNC_SHA} noVNC \
 && wget -nv -O websockify.zip "https://github.com/kanaka/websockify/archive/${WEBSOCKIFY_SHA}.zip" \
 && unzip -x websockify.zip \
 && mv websockify-${WEBSOCKIFY_SHA} ./noVNC/utils/websockify \
 && rm websockify.zip \
 && ln noVNC/vnc_auto.html noVNC/index.html

#======================
# Install SDK packages
#======================

ENV ANDROID_VERSION=8.1 \
    API_LEVEL=27 \ 
    PROCESSOR=x86 \
    SYS_IMG=x86 \
    IMG_TYPE=google_apis \
    BROWSER=chrome \
    CHROME_DRIVER=2.33 \
    GOOGLE_PLAY_SERVICE=12.8.74 \
    GOOGLE_PLAY_STORE=11.0.50 \
    GA=true GA_ENDPOINT=https://www.google-analytics.com/collect \
    GA_TRACKING_ID=UA-133466903-1 \
    GA_API_VERSION=1 \
    APP_RELEASE_VERSION=v1.10-p2 \
    APP_TYPE=Emulator

ENV PATH ${PATH}:${ANDROID_HOME}/build-tools

RUN yes | sdkmanager --licenses && \
    sdkmanager "platforms;android-${API_LEVEL}" "system-images;android-${API_LEVEL};${IMG_TYPE};${SYS_IMG}" "emulator"

#==============================================
# Download proper version of chromedriver
# to be able to use Chrome browser in emulator
#==============================================
RUN wget -nv -O chrome.zip "https://chromedriver.storage.googleapis.com/${CHROME_DRIVER}/chromedriver_linux64.zip" \
 && unzip -x chrome.zip \
 && rm chrome.zip

#================================================================
# Download Google Play Services APK and Play Store from apklinker
#================================================================
#Run wget -nv -O google_play_services.apk "https://www.apklinker.com/wp-content/uploads/uploaded_apk/5b5155e5ef4f8/com.google.android.gms_${GOOGLE_PLAY_SERVICE}-020700-204998136_12874013_MinAPI21_(x86)(nodpi)_apklinker.com.apk"
#Run wget -nv -O google_play_store.apk "https://www.apklinker.com/wp-content/uploads/uploaded_apk/5b632b1164e31/com.android.vending_${GOOGLE_PLAY_STORE}-all-0-PR-206665793_81105000_MinAPI16_(armeabi,armeabi-v7a,mips,mips64,x86,x86_64)(240,320,480dpi)_apklinker.com.apk"

#================================================
# noVNC Default Configurations
# These Configurations can be changed through -e
#================================================
ENV DISPLAY=:0 \
    SCREEN=0 \
    SCREEN_WIDTH=1600 \
    SCREEN_HEIGHT=900 \
    SCREEN_DEPTH=24+32 \
    LOCAL_PORT=5900 \
    TARGET_PORT=6080 \
    TIMEOUT=1 \
    VIDEO_PATH=/tmp/video \
    LOG_PATH=/var/log/supervisor

#================================================
# openbox configuration
# Update the openbox configuration files to:
#   + Use a single virtual desktop to prevent accidentally switching 
#   + Add background
#================================================
#ADD images/logo_dockerandroid.png /root/logo.png
ADD src/.fehbg /root/.fehbg
ADD src/rc.xml /etc/xdg/openbox/rc.xml
RUN echo /root/.fehbg >> /etc/xdg/openbox/autostart

#======================
# Workarounds
#======================
# Fix emulator from crashing when running as root user.
# See https://github.com/budtmo/docker-android/issues/223
ENV QTWEBENGINE_DISABLE_SANDBOX=1

#===============
# Expose Ports
#---------------
# 4723
#   Appium port
# 6080
#   noVNC port
# 5554
#   Emulator port
# 5555
#   ADB connection port
#===============
EXPOSE 4723 4567 6080 5554 5555

#======================
# Add Emulator Devices
#======================
COPY devices /root/devices

#====================================================
# Copy the repository, this should be downloaded from Jenkins.
# Also this repository has the app included, this should also be downloaded and copied from Jenkins
#====================================================
COPY repository /root/

#===================
# Run docker-appium
#===================
COPY src /root/src
COPY supervisord.conf /root/
RUN chmod -R +x /root/src && chmod +x /root/supervisord.conf

HEALTHCHECK --interval=2s --timeout=40s --retries=1 \
    CMD timeout 40 adb wait-for-device shell 'while [[ -z $(getprop sys.boot_completed) ]]; do sleep 1; done'

CMD /usr/bin/supervisord --configuration supervisord.conf

#===================
# Run clean test to downaload dependencies
#===================
RUN mvn clean test