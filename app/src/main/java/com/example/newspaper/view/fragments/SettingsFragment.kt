package com.example.newspaper.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newspaper.R
import com.example.newspaper.databinding.FragmentSettingsBinding
import com.example.newspaper.viewmodel.SettingsFragmentViewModel
import io.reactivex.rxjava3.schedulers.Schedulers

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(SettingsFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Слушаем, какой у нас сейчас выбран вариант в настройках
        viewModel.categoryPropertyLifeData.observe(viewLifecycleOwner, Observer<String> {
            when (it) {
                USA_LANG -> binding.radioGroup.check(R.id.radio_usa)
                UKR_LANG -> binding.radioGroup.check(R.id.radio_ukr)
                RUS_LANG -> binding.radioGroup.check(R.id.radio_rus)
            }
        })


        //Слушатель для отправки нового состояния в настройки
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            viewModel.deleteNews()
                .subscribeOn(Schedulers.io())
                .subscribe()
            when (checkedId) {
                R.id.radio_usa -> viewModel.putCategoryProperty(USA_LANG)
                R.id.radio_ukr -> viewModel.putCategoryProperty(UKR_LANG)
                R.id.radio_rus -> viewModel.putCategoryProperty(RUS_LANG)
            }
        }
    }

    companion object {
        private const val USA_LANG = "us"
        private const val UKR_LANG = "ua"
        private const val RUS_LANG = "ru"
    }
}