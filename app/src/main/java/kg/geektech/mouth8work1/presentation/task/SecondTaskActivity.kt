package kg.geektech.mouth8work1.presentation.task

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.mouth8work1.R
import kg.geektech.mouth8work1.databinding.ActivitySecondTaskBinding

class SecondTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondTaskBinding
    private var user: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLauncherRealization()
    }

    private fun initLauncherRealization() {
        binding.btnClicker.setOnClickListener {
            if (binding.editText.text?.isEmpty() == true) {
                Toast.makeText(this, getString(R.string.redactor_toast), Toast.LENGTH_SHORT)
                    .show()
            } else {
                user = binding.editText.text.toString()
                setResult(RESULT_OK, intent.putExtra(TaskActivity.USER_KEY, user))
                finish()
            }
        }
    }
}