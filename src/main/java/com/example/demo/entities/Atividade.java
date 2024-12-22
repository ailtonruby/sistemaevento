package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nome;
   private String descricao;
   private Double preco;

   @ManyToOne
   @JoinColumn(name = "categoria_id")
   private Categoria categoria;

   @OneToMany(mappedBy = "atividade")
   private List<Bloco> bloco = new ArrayList();

    @ManyToMany
    @JoinTable(name = "tb_participante_atividade",
            joinColumns = @JoinColumn(name = "participantes_id"),
            inverseJoinColumns = @JoinColumn(name = "atividades_id"))
    private Set<Participantes> participantes = new HashSet<>();

   public Atividade(int id, String nome, String descricao, Double preco) {
       this.id = id;
       this.nome = nome;
       this.descricao = descricao;
       this.preco = preco;
   }

   public Categoria getCategoria() {
       return this.categoria;
   }

    public void setCategoria(Categoria categoria) {
       this.categoria = categoria;
   }
   public int getId() {
       return this.id;
   }
   public void setId(int id) {
       this.id = id;
   }
   public String getNome() {
       return this.nome;
   }
   public void setNome(String nome) {
       this.nome = nome;
   }
   public String getDescricao() {
       return this.descricao;
   }
   public void setDescricao(String descricao) {
       this.descricao = descricao;
   }
   public Double getPreco() {
       return this.preco;
   }    public void setPreco(Double preco) {
       this.preco = preco;
   }

    public List<Bloco> getBloco() {
        return bloco;
    }

    public void setBloco(List<Bloco> bloco) {
        this.bloco = bloco;
    }

    public Set<Participantes> getParticipante() {
        return participantes;
    }

    public void setParticipante(Set<Participantes> participante) {
        this.participantes = participante;
    }
}
