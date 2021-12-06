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
                BUSINESS_CATEGORY -> binding.radioGroup.check(R.id.radio_business)
                SPORTS_CATEGORY -> binding.radioGroup.check(R.id.radio_sports)
                GENERAL_CATEGORY -> binding.radioGroup.check(R.id.radio_general)
            }
        })


        //Слушатель для отправки нового состояния в настройки
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_business -> viewModel.putCategoryProperty(BUSINESS_CATEGORY)
                R.id.radio_sports -> viewModel.putCategoryProperty(SPORTS_CATEGORY)
                R.id.radio_general -> viewModel.putCategoryProperty(GENERAL_CATEGORY)
            }
        }
    }

    companion object {
        private const val BUSINESS_CATEGORY = "business"
        private const val SPORTS_CATEGORY = "sports"
        private const val GENERAL_CATEGORY = "general"
    }
}