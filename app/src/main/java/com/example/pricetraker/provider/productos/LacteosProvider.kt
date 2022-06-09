package com.example.pricetraker.provider.productos

import com.example.pricetraker.data.DataProducto
class LacteosProvider {
    companion object {
        val listaDataProducto = listOf<DataProducto>(
            DataProducto(
                "Soprole",
                "Leche Blanca Entera",
                "https://jumbo.vtexassets.com/arquivos/ids/396690/Leche-entera-sin-tapa-1-L.jpg?v=637469297723670000",
                840,
            ),
            DataProducto(
                "Lider",
                "Leche Balnca Descremada",
                "https://s.cornershopapp.com/product-images/4677.jpg?versionId=7vVfkKGyj0nvhSi2DEF.TX9lud9JKHcE",
                820,
            ),
            DataProducto(
                "Colun",
                "Leche Blanca Descremada",
                "https://jumbo.vtexassets.com/arquivos/ids/396670/Leche-entera-1-L.jpg?v=637469297528530000",
                1050,
            ),
            DataProducto(
                "Nido",
                "Formula Lactea",
                "https://jumbo.vtexassets.com/arquivos/ids/410632/Leche-en-polvo-entera-tarro-15-kg.jpg?v=637469376491300000",
                6000,
            )
        )
    }
}


