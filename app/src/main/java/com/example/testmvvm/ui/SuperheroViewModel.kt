package com.example.testmvvm.ui

import androidx.lifecycle.MutableLiveData
import com.example.testmvvm.base.BaseViewModel
import com.example.testmvvm.models.Superheroe


class SuperheroViewModel : BaseViewModel() {

    private val name = MutableLiveData<String>()
    private val photo = MutableLiveData<String>()
    private val realName = MutableLiveData<String>()
    private val height = MutableLiveData<String>()
    private val power = MutableLiveData<String>()
    private val abilities = MutableLiveData<String>()
    private val groups = MutableLiveData<String>()

    fun bind(superheroe: Superheroe) {
        name.value = "Name: "+superheroe.name
        photo.value = superheroe.photo
        realName.value = "Real Name: "+superheroe.realName
        height.value = "Height: "+superheroe.height
        power.value = "Power: "+superheroe.power
        abilities.value = "Abilities: "+superheroe.abilities
        groups.value = "Groups: "+superheroe.groups
    }

    fun getPhoto(): MutableLiveData<String> {
        return photo

    }
    fun getName(): MutableLiveData<String> {
        return name
    }

    fun getRealName(): MutableLiveData<String> {
        return realName
    }

    fun getHeight(): MutableLiveData<String> {
        return height
    }

    fun getPower(): MutableLiveData<String> {
        return power
    }

    fun getAbilities(): MutableLiveData<String> {
        return abilities
    }

    fun getGroups(): MutableLiveData<String> {
        return groups
    }

}