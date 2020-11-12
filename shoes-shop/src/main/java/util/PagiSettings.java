package util;

import dal.product.ProductDAO;

public class PagiSettings {

    ProductDAO pd = new ProductDAO();

    private int totalProduct;
    private int numberProduct;
    private int totalPage;

    //3 Pagination options

    private void setNumProductAndTotalPage() {
        this.numberProduct = 12;
        this.totalPage = (totalProduct % numberProduct == 0) ? (totalProduct / numberProduct) : (totalProduct / numberProduct + 1);
    }

    public void paginationAll() {
        this.totalProduct = (pd.getAll() == null) ? 0 : pd.getAll().size();
        setNumProductAndTotalPage();
    }

    public void paginationBySearch(String txtSearch) {
        this.totalProduct = (pd.getAllBySearch(txtSearch) == null) ? 0 : pd.getAllBySearch(txtSearch).size();
        setNumProductAndTotalPage();
    }

    public void paginationByTypeID(int typeID) {
        this.totalProduct = (pd.getAllByType(typeID) == null) ? 0 : pd.getAllByType(typeID).size();
        setNumProductAndTotalPage();
    }


    //get pagination attributes

    public int getTotalProduct() {
        return totalProduct;
    }

    public int getNumberProduct() {
        return numberProduct;
    }

    public int getTotalPage() {
        return totalPage;
    }
}
