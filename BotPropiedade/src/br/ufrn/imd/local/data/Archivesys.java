/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.local.data;

import br.ufrn.imd.local.Observers.IObserver;
import br.ufrn.imd.local.bot.Categoria;
import br.ufrn.imd.local.bot.Item;
import br.ufrn.imd.local.bot.Local;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arthur
 */
public class Archivesys implements IObserver{
    
    private Map<Item,File> armazenamento;

    public void createItemData(int codigo, String nome, String descricao,Local localizacao,Categoria categoria) {
        Item tmp = new Item(codigo,nome,descricao,localizacao,categoria);
        createItemData(tmp);
    }
    public boolean createItemData(Item item){
      for(Map.Entry<Item,File> arm : armazenamento.entrySet()) {
          if(item.equals(arm.getKey())){
              return false;
          }
      }
      item.register(this);
      armazenamento.put(item, null);
      return true;
    }
    public void createFile(String name, Item item) {
        File file = null;
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Archivesys.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @Override
    public void update(Item self) {
        for(Map.Entry<Item,File> item : armazenamento.entrySet()) {
            if(item.getKey().equals(self)) {
                //update file
            }
        }
    }

}
