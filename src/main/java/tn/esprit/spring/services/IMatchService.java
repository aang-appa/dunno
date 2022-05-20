package tn.esprit.spring.services;

import tn.esprit.spring.entities.MatchFootball;

public interface IMatchService {
	public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1, Integer idEquipe2);
}
