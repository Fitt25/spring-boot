package com.github.Fitt25.springboot;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SoftwareEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String techStack;
    @Column(columnDefinition = "TEXT")
    private String recommendation;

    public SoftwareEngineer(Integer id,
                            String name,
                            String techStack,
                            String recommendation) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
        this.recommendation = recommendation;

    }

    public SoftwareEngineer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(techStack, that.techStack) && Objects.equals(recommendation, that.recommendation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techStack, recommendation);
    }
}
