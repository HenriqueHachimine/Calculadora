package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var botaoDivisao: Button
    private lateinit var botaoLimpar: Button
    private lateinit var botaoIgual: Button
    private lateinit var botaoMultiplicador: Button
    private lateinit var botaoSubstracao: Button
    private lateinit var botaoAdicao: Button
    private lateinit var botaoSete: Button
    private lateinit var botaoOito: Button
    private lateinit var botaoNove: Button
    private lateinit var botaoQuatro: Button
    private lateinit var botaoCinco: Button
    private lateinit var botaoSeis: Button
    private lateinit var botaoUm: Button
    private lateinit var botaoDois: Button
    private lateinit var botaoTres: Button
    private lateinit var botaoZero: Button
    private lateinit var result:TextView
    private lateinit var memoria:TextView
    private var texto = ""
    private var valor1 = 0
    private var valor2 = 0
    private var tipoOperacao = TipoOperacao.NENHUM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupClicks()
    }

    private fun setupView() {
        memoria = findViewById(R.id.memoria)
        botaoDivisao = findViewById(R.id.btn_divisao)
        botaoLimpar = findViewById(R.id.btn_limpar)
        botaoIgual = findViewById(R.id.btn_igual)
        botaoMultiplicador = findViewById(R.id.btn_multiplicador)
        botaoSubstracao = findViewById(R.id.btn_subtracao)
        botaoAdicao = findViewById(R.id.btn_adicao)
        botaoSete = findViewById(R.id.btn_sete)
        botaoOito = findViewById(R.id.btn_oito)
        botaoNove = findViewById(R.id.btn_nove)
        botaoQuatro = findViewById(R.id.btn_quatro)
        botaoCinco = findViewById(R.id.btn_cinco)
        botaoSeis = findViewById(R.id.btn_seis)
        botaoUm = findViewById(R.id.btn_um)
        botaoDois = findViewById(R.id.btn_dois)
        botaoTres = findViewById(R.id.btn_tres)
        botaoZero = findViewById(R.id.btn_zero)
        result = findViewById(R.id.tv_resultado)
        result.text = texto
    }

    private fun setupClicks() {
        botaoIgual.setOnClickListener {
            if (!verificaSeJaTemOperador() && texto.isNotEmpty()) {
                memoria.text = "${memoria.text} $texto = "
                calcular()
                texto = ""
                tipoOperacao = TipoOperacao.NENHUM
            }
        }
        botaoDivisao.setOnClickListener {

            texto = ""
            memoria.text = "$valor1 / "

            tipoOperacao = TipoOperacao.DIVISAO
        }
        botaoAdicao.setOnClickListener {

            texto = ""
            memoria.text = "$valor1 + "
            tipoOperacao = TipoOperacao.ADICAO
        }
        botaoSubstracao.setOnClickListener {

            texto = ""
            memoria.text = "$valor1 - "
            tipoOperacao = TipoOperacao.SUBTRACAO
        }
        botaoMultiplicador.setOnClickListener {
            texto = ""
            memoria.text = "$valor1 * "
            tipoOperacao = TipoOperacao.MULTIPLICACAO
        }
        botaoLimpar.setOnClickListener {
            limpar()
        }
        botaoZero.setOnClickListener {
            texto += "0"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoUm.setOnClickListener {
            texto += "1"
            result.text = texto
            if (verificaSeJaTemOperador()) {
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoDois.setOnClickListener {
            texto += "2"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoTres.setOnClickListener {
            texto += "3"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoQuatro.setOnClickListener {
            texto += "4"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoCinco.setOnClickListener {
            texto += "5"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoSeis.setOnClickListener {
            texto += "6"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoSete.setOnClickListener {
            texto += "7"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoOito.setOnClickListener {
            texto += "8"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
        botaoNove.setOnClickListener {
            texto +="9"
            result.text = texto
            if ( verificaSeJaTemOperador()){
                valor1 = texto.toInt()
            } else {
                valor2 = texto.toInt()
            }
        }
    }

    private fun calcular() {
        when(tipoOperacao) {
            TipoOperacao.ADICAO -> {
                var valor = valor1 + valor2
                result.text = valor.toString()
            }
            TipoOperacao.MULTIPLICACAO ->{
                var valor = valor1 * valor2
                result.text = valor.toString()
            }
            TipoOperacao.SUBTRACAO -> {
                var valor = valor1 - valor2
                result.text = valor.toString()
            }
            TipoOperacao.DIVISAO -> {
                var valor = valor1/valor2
                result.text = valor.toString()
            }
        }
    }

    private fun verificaSeJaTemOperador(): Boolean {
        return tipoOperacao == TipoOperacao.NENHUM
    }

    private fun limpar() {
        valor1 = 0
        valor2 = 0
        memoria.text = ""
        result.text = valor1.toString()
        tipoOperacao = TipoOperacao.NENHUM
        texto = ""

    }

}