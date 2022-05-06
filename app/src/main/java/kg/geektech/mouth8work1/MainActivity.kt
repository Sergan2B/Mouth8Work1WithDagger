package kg.geektech.mouth8work1

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kg.geektech.mouth8work1.databinding.ActivityMainBinding
import kg.geektech.mouth8work1.domain.ShopItem
import kg.geektech.mouth8work1.presentation.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mSettings: SharedPreferences
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initObservers()
        initListeners()
    }

    private fun initListeners() {
        //get shopList для получения
        binding.btnGetShopList.setOnClickListener {
            viewModel.getShopList()
        }
        //add shopItem
        binding.btnAddShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
            viewModel.addShopItem(ShopItem(binding.editText.text.toString(), 2, true))
            else Toast.makeText(applicationContext, "Заполните текст", Toast.LENGTH_LONG).show()

        }
        //edit ShopItem
        binding.btnEditShopItem.setOnClickListener {
            viewModel.editShopItem(ShopItem(binding.editText.text.toString(), 2, true))
        }
        //delete ShopItem
        binding.btnDeleteShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
            viewModel.deleteShopItem(ShopItem(binding.editText.text.toString(), 2, true))
            else Toast.makeText(applicationContext, "Заполните текст индексом 22", Toast.LENGTH_LONG).show()

        }
        //get shopItem
        binding.btnGetShopItem.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty())
                viewModel.getShopItem(binding.editText.text.toString().toInt())
            else Toast.makeText(applicationContext, "Заполните текст индексом", Toast.LENGTH_LONG).show()
        }
    }

    private fun initObservers() {
        viewModel.shopListLD.observe(this) {
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
        }
        viewModel.shopListLDItem.observe(this) {
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun saveText() {
        mSettings = getPreferences(MODE_PRIVATE)
        val editor = mSettings.edit()
        editor.putString("KEY14", binding.editText.text.toString().trim())
        editor.apply()
    }

    private fun loadText() {
        mSettings = getPreferences(MODE_PRIVATE)
        val savedText = mSettings.getString("KEY14", "")
        binding.editText.setText(savedText)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        loadText()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveText()
    }
}