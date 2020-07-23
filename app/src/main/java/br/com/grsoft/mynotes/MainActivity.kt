package br.com.grsoft.mynotes

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var preferences: NotesPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = NotesPreferences(this)

        if (!preferences.notes[0].equals("")) {
            editTextNotes.setText(preferences.notes.toString())
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            if (editTextNotes.text.toString().isNullOrBlank()) {
                Snackbar.make(view, "Preencha alguma anotação antes de salvar!", Snackbar.LENGTH_LONG)
                   .show()
            } else {
                preferences.saveNotes(editTextNotes.text.toString())

                Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}