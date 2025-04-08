package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.entity.SponsoredProjectEntity;
import com.project.repository.SponsoredProjectRepo;

@Service
public class SponsoredProjectSer {

    @Autowired
    private SponsoredProjectRepo repo;

    public void savelogic(Integer rollno, String studentname, String guide, String projectnm, String companydetails, MultipartFile image1, MultipartFile image2) throws IOException {
        SponsoredProjectEntity rep = new SponsoredProjectEntity();
        rep.setRollno(rollno);
        rep.setStudentname(studentname);
        rep.setGuide(guide);
        rep.setProjectnm(projectnm);
        rep.setCompanydetails(companydetails);
        
        // Convert MultipartFile to byte[] and set it in the entity
        rep.setImage1(image1.getBytes());
        rep.setImage2(image2.getBytes());
        
        // Save the entity in the repository
        repo.save(rep);
    }

    public List<SponsoredProjectEntity> getAllFormData() {
        return repo.findAll();
    }
    public void deleteById(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
    }
}
