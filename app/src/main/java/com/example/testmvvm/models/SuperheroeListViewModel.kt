package com.example.testmvvm.models

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.testmvvm.BaseViewModel
import com.example.testmvvm.R
import com.example.testmvvm.network.SuperheroesApi
import com.example.testmvvm.ui.SuperheroListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SuperheroeListViewModel : BaseViewModel(){
    @Inject
    lateinit var postApi: SuperheroesApi
    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val superHeroListAdapter:MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadSuperheroes() }
    val superheroListAdapter: SuperheroListAdapter = SuperheroListAdapter()

    override fun onCleared() {
        subscription.dispose()
    }

    init{
        loadSuperheroes()
    }

    private fun loadSuperheroes(){
        subscription = postApi.getSuperheroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveSuperheroListStart() }
            .doOnTerminate { onRetrieveSuperheroFinish() }
            .subscribe(
                { result -> onRetrieveSuperheroSuccess(result) },
                { onRetrieveSuperheroError() }
            )
    }

    private fun onRetrieveSuperheroListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null

    }

    private fun onRetrieveSuperheroFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveSuperheroSuccess(superHeroList:SuperheroesResponse){
        superheroListAdapter.updateSuperHeroList(superHeroList)
    }

    private fun onRetrieveSuperheroError(){
        errorMessage.value = R.string.post_error

    }








}