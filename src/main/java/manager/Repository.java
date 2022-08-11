package manager;

public class Repository {

    Product[] products = new Product[0];

    public void addProduct(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;

    }

    public void removeProductId(int id) {
        int index = 0;
        int indexForCorrect = 0;// проверка существет ли id в массиве
        Product[] tmps = new Product[products.length];
        for (Product product : products) {
            if (product.getId() == id) {
                break;
            } else {
                tmps[indexForCorrect] = product;
                indexForCorrect++;
            }
            if (indexForCorrect == products.length) {
                products = tmps;//выход если не существует, возращает массив без изменений
                return;
            }
        }
        Product[] tmp = new Product[products.length - 1];// удаление id
        for (
                Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
            products = tmp;
        }
    }

    public Product[] findAll() {
        return products;
    }
}
