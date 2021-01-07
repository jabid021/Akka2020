package dao;

import java.util.List;

import model.PC;

public interface IDAOPC extends IDAO<PC,Integer>{

		public List<PC> findDisponibles();
}
