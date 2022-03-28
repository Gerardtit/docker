package com.automation.mobile.services.perfecto.models;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class ApiSchema {

    @Getter
    @ToString
    public class PerfectoExecInfo {

        List<Resources> resources;

        @Getter
        @ToString
        public class Resources {

            String id;
            String externalId;
            List<Resources.Artifacts> artifacts;

            @Getter
            @ToString
            public class Artifacts {

                String type;
                String path;
                String fileName;
                boolean zipped;
            }


        }
    }
}
