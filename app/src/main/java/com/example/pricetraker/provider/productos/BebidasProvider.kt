package com.example.pricetraker.provider.productos

import com.example.pricetraker.data.DataProducto
class BebidasProvider {
    companion object {
        val listaDataProducto = listOf<DataProducto>(
            DataProducto(
                "Coca-Cola",
                "2,5L",
                "https://cdnx.jumpseller.com/serviceshop/image/7978735/thumb/540/540?1653835910",
                1990,

            ),
            DataProducto(
                "Pepsi",
                "3L",
                "https://www.distribuidorasantiago.cl/wp-content/uploads/2018/12/639-BEBIDA-PEPSI.jpg",
                2390,

            ),
            DataProducto(
                "Coca-Cola",
                "350ml",
                "https://cdnx.jumpseller.com/mgdrinks/image/11230943/thumb/540/540?1623706222",
                600,
            ),
            DataProducto(
                "Sprite",
                "2,5L",
                "https://mercadosaavedra.cl/wp-content/uploads/2021/04/sprite-2.5-no-retorn.jpg",
                1990,
            )
        )
    }
}


