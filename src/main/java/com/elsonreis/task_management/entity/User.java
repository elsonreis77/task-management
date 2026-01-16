package com.elsonreis.task_management.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * ===============================
 * ENTITY: User
 * ===============================

 * Esta classe representa um usuário do sistema.
 * Cada objeto User vira uma linha na tabela "users" no banco de dados.
 */
@Entity // Diz ao JPA que esta classe deve virar uma tabela no banco
@Table(name = "users") // Nome da tabela no banco
public class User {

    /**
     * ID do usuário (chave primária).
     * O valor é gerado automaticamente pelo banco.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do usuário.
     * nullable = false → campo obrigatório.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Email do usuário.
     * unique = true → não permite emails duplicados.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Senha do usuário.
     * (Por enquanto em texto puro, depois usaremos criptografia)
     */
    @Column(nullable = false)
    private String password;

    /**
     * Data de criação do usuário.
     * Não é enviada pelo cliente, o sistema define sozinho.
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * Método executado automaticamente ANTES de salvar no banco.
     * Usamos para preencher a data de criação.
     */
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // ===============================
    // GETTERS E SETTERS
    // ===============================

    public Long getId() {
        return id;
    }

    // Não criamos setter para ID porque ele é gerado pelo banco

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
