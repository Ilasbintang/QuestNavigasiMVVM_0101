package com.example.p7


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p7.view.FormIsian
import com.example.p7.view.TampilData

enum class Navigasi {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Navigasi.FormulirSaya.name
    ) {
        composable(route = Navigasi.FormulirSaya.name) {
            FormIsian(
                // PERBAIKAN: Ubah menjadi 'onSubmitDictClick' / 'onSubmitBtnClick' (huruf kecil di awal)
                onSubmitBtnClick = {
                    navController.navigate(Navigasi.Detail.name)
                }
            )
        }
        composable(route = Navigasi.Detail.name) {
            TampilData(
                onBackBtnClick = {
                    cancelAndBackToFormulir(navController)
                }
            )
        }
    }
}

private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    // PERBAIKAN: Cukup gunakan popBackStack() standar untuk kembali ke halaman sebelumnya dengan aman
    navController.popBackStack()
}