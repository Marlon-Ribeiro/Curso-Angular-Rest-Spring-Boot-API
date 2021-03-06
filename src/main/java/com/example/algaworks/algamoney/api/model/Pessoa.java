package com.example.algaworks.algamoney.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name="pessoa")
public class Pessoa {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long codigo;

 @NotNull
 @Size(min = 3, max = 20)
private  String nome;
@Embedded
private Endereco endereco;

@NotNull
private  Boolean ativo;

 public Long getCodigo() {
  return codigo;
 }

 public void setCodigo(Long codigo) {
  this.codigo = codigo;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public Endereco getEndereco() {
  return endereco;
 }

 public void setEndereco(Endereco endereco) {
  this.endereco = endereco;
 }

 public Boolean getAtivo() {
  return ativo;
 }

 public void setAtivo(Boolean ativo) {
  this.ativo = ativo;
 }

 @JsonIgnore
 @Transient
 public  boolean isInativa(){
  return  !this.ativo;
 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (!(o instanceof Pessoa)) return false;
  Pessoa pessoa = (Pessoa) o;
  return Objects.equals(getCodigo(), pessoa.getCodigo()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getEndereco(), pessoa.getEndereco()) && Objects.equals(getAtivo(), pessoa.getAtivo());
 }

 @Override
 public int hashCode() {
  return Objects.hash(getCodigo(), getNome(), getEndereco(), getAtivo());
 }
}

