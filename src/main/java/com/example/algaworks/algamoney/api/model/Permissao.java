package com.example.algaworks.algamoney.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "permissao")
public class Permissao {
    @Id
    private long codigo;
    private String descricao;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permissao)) return false;

        Permissao permissao = (Permissao) o;

        if (getCodigo() != permissao.getCodigo()) return false;
        return getDescricao() != null ? getDescricao().equals(permissao.getDescricao()) : permissao.getDescricao() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getCodigo() ^ (getCodigo() >>> 32));
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        return result;
    }
}
