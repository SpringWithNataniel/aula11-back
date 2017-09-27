/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.aula.natan.service;

import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuario() {
        return usuarioRepository.findAll();
    }

    public Page<Usuario> listaPaginada(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return usuarioRepository.findAll(pages);
    }

    public List<Usuario> buscaPorNome(String nome) {
        return usuarioRepository.findByNomeLikeIgnoreCase(nome);
    }

    public Usuario salvarUsuario(Usuario usuarioAdd) {
        return usuarioRepository.save(usuarioAdd);
    }

    public void deleteUsuario(String id) {
        usuarioRepository.delete(id);
    }

    public Usuario getById(String id) {
        return usuarioRepository.findOne(id);
    }

}
