package com.automation.mobile.models;

import java.util.List;

public class FeatureScenario {

    private String name;

    private List<ScenarioStep> stepList;

    private int id;

    private int status;

    private String comment;

    private String fileName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScenarioStep> getStepList() {
        return stepList;
    }

    public void setStepList(List<ScenarioStep> stepList) {
        this.stepList = stepList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScenarioStep getFromName(String name) {

        ScenarioStep scenarioStep = null;

        for (ScenarioStep step : stepList) {

            if (step.getName().equalsIgnoreCase(name) && step.getCounter() == 0) {

                scenarioStep = step;

                break;
            }
        }

        return scenarioStep;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
