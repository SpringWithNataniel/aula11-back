package io.spring.aula.natan.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@Document
public class Perfil implements GrantedAuthority {

    @Id
    private String id;

    private String nome;

    public Perfil() {
    }

    public Perfil(String nome) {
        this.nome = nome;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }

}
