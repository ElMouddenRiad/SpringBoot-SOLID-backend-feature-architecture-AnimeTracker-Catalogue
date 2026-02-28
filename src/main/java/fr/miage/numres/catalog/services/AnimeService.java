package fr.miage.numres.catalog.services;


import fr.miage.numres.spring_demo_numres_25_26.catalogue.dtos.AnimeCreateDTO;
import fr.miage.numres.spring_demo_numres_25_26.catalogue.dtos.AnimeDTO;
import fr.miage.numres.spring_demo_numres_25_26.catalogue.mappers.AnimeMapper;
import fr.miage.numres.spring_demo_numres_25_26.catalogue.repositories.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    private final AnimeRepository repository;
    private final AnimeMapper mapper;

    // Injection par constructeur (Bonne pratique)
    public AnimeService(AnimeRepository repository, AnimeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AnimeDTO> getAllAnimes() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<AnimeDTO> getAnimeById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    public AnimeDTO createAnime(AnimeCreateDTO createDTO) {
        var entity = mapper.toEntity(createDTO);
        var savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }
}