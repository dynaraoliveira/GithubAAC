package br.com.dynaraoliveira.githubaac.ui.userprofile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.dynaraoliveira.githubaac.R
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_user_profile.*
import javax.inject.Inject

class UserProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpDagger()
        setUpViewModel()
        setUpView()
    }

    private fun setUpDagger() {
        AndroidSupportInjection.inject(this)
    }

    private fun setUpView() {
        btPesquisar.setOnClickListener {
            viewModel.getUser(etUsuario.text.toString())
            viewModel.user.observe(this, Observer {
                tvUsuario.text = it?.name
                Picasso.get().load(it?.avatarURL).into(ivUsuario)
            })
        }
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(UserProfileViewModel::class.java)
    }
}
