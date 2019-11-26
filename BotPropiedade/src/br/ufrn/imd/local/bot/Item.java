package br.ufrn.imd.local.bot;

import br.ufrn.imd.local.Observers.IObserver;
import br.ufrn.imd.local.Observers.ISubject;
import java.util.ArrayList;

public class Item implements ISubject{
    private int codigo;
    private String nome;
    private String descricao;
    private Local localizacao;
    private Categoria categoria;
    private ArrayList<IObserver> observer;
    
    public Item(int codigo, String nome, String descricao, Local localizacao, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.categoria = categoria;
        this.observer = new ArrayList<IObserver>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
        notificar(this);        
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        notificar(this);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        notificar(this);
    }

    public Local getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Local localizacao) {
        this.localizacao = localizacao;
        notificar(this);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        notificar(this);
    }
    
    public void register(IObserver o) {
        this.observer.add(o);
    }
    public void unregister(IObserver o) {
        this.observer.remove(o);
    }
    public void notificar(Item self) {
        for(IObserver i : observer) {
            i.update(self);
        }
    }
}
