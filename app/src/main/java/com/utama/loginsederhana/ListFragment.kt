package com.utama.loginsederhana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.utama.loginsederhana.databinding.DialogAddKendaraanBinding
import com.utama.loginsederhana.databinding.FragmentListBinding
import kotlinx.coroutines.launch

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: AppDatabase
    private lateinit var adapter: KendaraanAdapter
    private val listKendaraan = mutableListOf<Kendaraan>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getDatabase(requireContext())

        setupRecyclerView()
        loadData()

        binding.fabAdd.setOnClickListener {
            showAddDialog()
        }
    }

    private fun setupRecyclerView() {
        adapter = KendaraanAdapter(listKendaraan)
        binding.rvKendaraan.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKendaraan.adapter = adapter
    }

    private fun loadData() {
        lifecycleScope.launch {
            val data = db.kendaraanDao().getAllKendaraan()
            listKendaraan.clear()
            listKendaraan.addAll(data)
            
            if (data.isEmpty()) {
                val initialData = listOf(
                    Kendaraan(nama = "Toyota Avanza", jenis = "Mobil", deskripsi = "7 Seats • Manual", harga = "Rp 350.000"),
                    Kendaraan(nama = "Honda Vario 160", jenis = "Motor", deskripsi = "Automatic • 160cc", harga = "Rp 80.000")
                )
                initialData.forEach { kendaraan ->
                    db.kendaraanDao().insertKendaraan(kendaraan)
                }
                // Refresh data after insertion
                val updatedData = db.kendaraanDao().getAllKendaraan()
                listKendaraan.clear()
                listKendaraan.addAll(updatedData)
            }
            
            adapter.notifyDataSetChanged()
        }
    }

    private fun showAddDialog() {
        val dialogBinding = DialogAddKendaraanBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .create()

        val items = listOf("Mobil", "Motor")
        val adapterJenis = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        dialogBinding.actvJenis.setAdapter(adapterJenis)

        dialogBinding.btnSave.setOnClickListener {
            val nama = dialogBinding.etNama.text.toString().trim()
            val jenis = dialogBinding.actvJenis.text.toString().trim()
            val desc = dialogBinding.etDesc.text.toString().trim()
            val harga = dialogBinding.etHarga.text.toString().trim()

            if (nama.isNotEmpty() && jenis.isNotEmpty() && harga.isNotEmpty()) {
                lifecycleScope.launch {
                    val newKendaraan = Kendaraan(nama = nama, jenis = jenis, deskripsi = desc, harga = harga)
                    db.kendaraanDao().insertKendaraan(newKendaraan)
                    loadData()
                    dialog.dismiss()
                    Toast.makeText(context, "Kendaraan berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Mohon lengkapi data", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}