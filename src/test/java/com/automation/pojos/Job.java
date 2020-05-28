package com.automation.pojos;

import com.google.gson.annotations.SerializedName;

public class Job {
    @SerializedName("job_id")//We have add this if variable name in java is different variable name in JSON
    private String jobId;
    private String job_title; //otherwise,GSON will map them automatically
    private Integer min_salary;
    private Integer max_salary;

    public Job(){

    }

    public Job(String job_id, String job_title, Integer min_salary, Integer max_salary) {
        this.jobId = jobId;
        this.job_title = job_title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    public String getJob_id() {
        return jobId;
    }

    public void setJob_id(String job_id) {
        this.jobId = jobId;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Integer getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Integer min_salary) {
        this.min_salary = min_salary;
    }

    public Integer getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Integer max_salary) {
        this.max_salary = max_salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "job_id='" + jobId + '\'' +
                ", job_title='" + job_title + '\'' +
                ", min_salary=" + min_salary +
                ", max_salary=" + max_salary +
                '}';
    }
}
