package com.example.ellenbarros_rm92899

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ellenbarros_rm92899.ui.theme.EllenBarros_RM92899Theme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "EcoDicas"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val tituloText = findViewById<EditText>(R.id.tituloText)
        val descricaoText = findViewById<EditText>(R.id.descricaoText)
        button.setOnClickListener {
            if (tituloText.text.isEmpty() || descricaoText.text.isEmpty() ) {
                tituloText.error = "Preencha um valor"
                descricaoText.error = "Preencha um valor"

                return@setOnClickListener
            }

            val titulo = ItemModel(tituloText.text.toString())
            val descricao = ItemModel(descricaoText.text.toString())
            itemsAdapter.addItem(titulo)
            itemsAdapter.addItem(descricao)
            tituloText.text.clear()
            descricaoText.text.clear()

        }
    }
}