package com.github.Fitt25.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AiService aiService;
    public SoftwareEngineerService(
            SoftwareEngineerRepository softwareEngineerRepository, AiService aiService) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }
    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(id + " not found"));
    }
    public void insertSoftwareEngineer(
            SoftwareEngineer softwareEngineer) {
        String prompt = """
                Based on the programming tech stack %s that %s has given 
                Provide a full learning path and recommendations for this person
                """.formatted(
                        softwareEngineer.getTechStack(),
                softwareEngineer.getName()
        );
        System.out.println("AI prompt: " + prompt);
        String chatRes = "";
        try {
            chatRes = aiService.chat(prompt);
        } catch (Exception e) {
            throw new RuntimeException("Error calling AI service", e);
        }
        softwareEngineer.setRecommendation(chatRes);
        softwareEngineerRepository.save(softwareEngineer);
    }
    public void deleteSoftwareEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    id + " not found"
            );
        }
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer update) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SoftwareEngineer with ID " + id + " not found"));
        softwareEngineer.setName(update.getName());
        softwareEngineer.setTechStack(update.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);
    }
}
