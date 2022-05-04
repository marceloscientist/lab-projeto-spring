package one.dio.gof.model;

import javax.persistence.*;

@Entity
public
class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Address address;

    public
    Long getId ( ) {
        return id;
    }

    public
    void setId (Long id) {
        this.id = id;
    }

    public
    String getNome ( ) {
        return nome;
    }

    public
    void setNome (String nome) {
        this.nome = nome;
    }



    public
    void setAddress (Address address) {
        this.address = address;
    }

    public
    Address getAddress ( ) {
        return address;
    }
}
