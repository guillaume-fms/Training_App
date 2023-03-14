package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Logger;

import fr.fms.entities.Training;

public interface Dao <T>{

	public Connection connection = BddConnection.getConnection();

	public static final Logger logger = Logger.getLogger(Dao.class.getName());


	// Ajout d'une nouvelle occurence en base de données
	public boolean create(T obj);

	// Renvoi un objet correspondant à l'ID en base de données
	public T read(int id);

	// Met à jour l'objet en base, renvoi vrai si c'est fait
	public boolean update(T obj);

	// Supprime un objet en base, renvoi vrai si c'est fait
	public boolean delete(T obj);

	// Renvoi tous les objets de la table correspondante
	public ArrayList<T> readAll();

	ArrayList<Training> readAll(int id);



}

