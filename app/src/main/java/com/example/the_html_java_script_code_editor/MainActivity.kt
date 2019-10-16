package com.example.the_html_java_script_code_editor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var user_code:AutoCompleteTextView
    lateinit var run_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user_code=findViewById(R.id.usercode)
        run_btn=findViewById(R.id.run_btn)

        run_btn.setOnClickListener()
        {
            Run()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId)
        {
            R.id.run->{
                Run()
                return true
            }

            R.id.clear->{
                user_code.setText("")
                return true
            }

            R.id.close->{
                finish()
                return true
            }

            R.id.add_html_code->{

                user_code.setText("<?DOCTYPE HTML>\n"+
                        "<HTML>\n"+
                        "<HEAD>\n"+
                        "<TITLE>Page Title</TITLE>\n"+
                        "</HEAD>\n"+
                        "<BODY>\n"+
                        "\n"+
                        "<h1>My First Heading</h1>\n"+
                        "<h2>My Second Heading</h2>\n"+
                        "\n"+
                        "</BODY>\n"+
                        "</HTML>"

                )

                return true
            }
        }
        return true
    }

    private fun Run()
    {
        val intent=Intent(this@MainActivity,code_activity::class.java)
        intent.putExtra("code",user_code.text.toString())
        startActivity(intent)
    }
}
