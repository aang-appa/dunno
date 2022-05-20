package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Division;
import tn.esprit.spring.entities.Equipe;
import tn.esprit.spring.entities.Joueur;
import tn.esprit.spring.entities.MatchFootball;
import tn.esprit.spring.entities.Poste;
import tn.esprit.spring.repository.EquipeRepository;
import tn.esprit.spring.repository.JoueurRepository;
import tn.esprit.spring.repository.MatchRepository;

@Service
public class JoueurService implements IJoueurService {
	@Autowired
	EquipeRepository equipeRepository;
	@Autowired
	JoueurRepository joueurRepository;
	@Autowired
	MatchRepository matchRepository;
	
	
	@Override
	public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe) {
		Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
		Joueur toReturn = null;
		if (equipe != null) {
			joueur.setEquipe(equipe);
			equipe.getJoueurs().add(joueur);
			
			toReturn = joueurRepository.save(joueur);
			equipeRepository.save(equipe);
		}
		
		return toReturn;
	}



	@Override
	public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, float taille) {
		List<Joueur> allPlayers = joueurRepository.findAll();
		
		List<Joueur> playersToReturn = new ArrayList<>();
		
		for(int i = 0; i < allPlayers.size(); i++) {
			if (allPlayers.get(i).getTaille() > taille && allPlayers.get(i).getPoste() == poste) {
				playersToReturn.add(allPlayers.get(i));
			}
		}
		
		return playersToReturn;
	}



	@Override
	public List<Joueur> afficherJoueurDuMatchParDivisionEtPoste(Division division, Poste poste, Integer idMatch) {
		MatchFootball match = matchRepository.findById(idMatch).orElse(null);
		List<Joueur> playersToReturn = new ArrayList<>();
		
		if (match != null) {
			
			List<Equipe> equipes = match.getEquipes();
			
			for(int i = 0; i < equipes.size(); i++) {
				for(int j = 0; j < equipes.getJoueurs().size(); j++) {
					if (equipes.getJoueurs().get(i).getPoste() == poste && equipes.getJoueurs().get(i).getDivision() == division) {
						playersToReturn.add(equipes.getJoueurs().get(i));
					}
				}
			}
			
		}
		return playersToReturn;
	}

}
