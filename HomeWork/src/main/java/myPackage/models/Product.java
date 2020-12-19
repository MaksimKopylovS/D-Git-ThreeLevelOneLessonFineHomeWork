package myPackage.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id

    @Column(name = "id")
    //Постаянно получал ошибку
    //020-12-17 17:39:31 ERROR SqlExceptionHelper:142 - Table 'hibernate.hibernate_sequence' doesn't exist
    //Пока не поставил параметр  strategy = GenerationType.IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    public Product(String title, int cost){
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return String.format("Product: id: %d, title: %s, cost: %d", id, title, cost );
    }

}
