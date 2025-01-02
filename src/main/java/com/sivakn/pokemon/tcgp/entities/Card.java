package com.sivakn.pokemon.tcgp.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int hp;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Move> moves;
    private boolean basic;
    private boolean ex;

    private Card(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setType(builder.type);
        setHp(builder.hp);
        setMoves(builder.moves);
        setBasic(builder.basic);
        setEx(builder.ex);
    }

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public boolean isBasic() {
        return basic;
    }

    public void setBasic(boolean basic) {
        this.basic = basic;
    }

    public boolean isEx() {
        return ex;
    }

    public void setEx(boolean ex) {
        this.ex = ex;
    }


    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", hp=" + hp +
                ", moves=" + moves +
                ", basic=" + basic +
                ", ex=" + ex +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Type type;
        private int hp;
        private List<Move> moves;
        private boolean basic;
        private boolean ex;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder type(Type val) {
            type = val;
            return this;
        }

        public Builder hp(int val) {
            hp = val;
            return this;
        }

        public Builder moves(List<Move> val) {
            moves = val;
            return this;
        }

        public Builder basic(boolean val) {
            basic = val;
            return this;
        }

        public Builder ex(boolean val) {
            ex = val;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }
}
