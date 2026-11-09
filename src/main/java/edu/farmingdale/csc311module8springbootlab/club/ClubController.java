package edu.farmingdale.csc311module8springbootlab.club;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/clubs")
public class ClubController {

    private final ClubRepository clubRepository;

    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @GetMapping
    public List<Club> getAllClubs(String category){
        if(category!=null){
            return clubRepository.findByCategoryIgnoreCase(category);
        }
        return clubRepository.findAll();
    }

    @GetMapping("/{id}")
    public Club idSearch(Long id){
        if(id==null || !clubRepository.existsById(id)){
            return clubRepository.getReferenceById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No club with id " + id);
    }

    @PostMapping
    public void saveClub(@Valid @RequestBody Club club){
        clubRepository.save(club);
    }



}
