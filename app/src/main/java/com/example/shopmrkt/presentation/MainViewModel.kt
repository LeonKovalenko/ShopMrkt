package com.example.shopmrkt.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopmrkt.data.ShopListRepositoryImpl
import com.example.shopmrkt.domain.DeleteShopItemUseCase
import com.example.shopmrkt.domain.EditShopItemUseCase
import com.example.shopmrkt.domain.GetShopListUseCase
import com.example.shopmrkt.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }



}