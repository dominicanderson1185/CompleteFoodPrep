package xlost.com;

public class FoodModel {

    private Integer id;
    private String name;
    private Integer amount;
    private Integer age;

    public FoodModel(int id, String name, Integer amount, Integer age) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.age = age;
    }
/*

@Override
    public String toString() {
        return "FoodModel{" + "id=" + id +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", age=" + age +
                '}';
    }
 */


    @Override
    public String toString() {
        return "Item name: " + name  + "\n" + "Item amount:   " + amount + "\n"+ "Expiration Date:  " +  age ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}

