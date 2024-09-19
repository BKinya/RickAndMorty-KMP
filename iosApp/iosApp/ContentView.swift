import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ZStack{
            // background
            Color(red: 34/255, green: 34/255, blue: 34/255, opacity: 1)
                .ignoresSafeArea(.all)


            // foreground
            ComposeView()
        }

    }
}



