package com.nailshair.salao.api.pessoa.controller;

import com.nailshair.salao.api.NailshairApiApplication;
import com.nailshair.salao.api.pessoa.entity.Pessoa;
import com.nailshair.salao.api.pessoa.repository.PessoaRepository;
import com.nailshair.salao.api.pessoa.service.PessoaService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NailshairApiApplication.class)
public class PessoaControllerTest {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaService pessoaService;

    @Rule
    public ExpectedException erroEsperado = ExpectedException.none();

    public Pessoa pessoaPreenchida() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome Teste");
        pessoa.setCpf("01234567891");
        pessoa.setDataNascimento("23/03/1994");
        pessoa.setTelefone("62 992412741");
        return pessoa;
    }

    public Pessoa pessoaPreenchida2() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("nome Teste2");
        pessoa.setCpf("01234567894");
        pessoa.setDataNascimento("00/00/2133");
        pessoa.setTelefone("62 99241572");
        return pessoa;
    }

    @Test
    public void buscarPeloNomeIgnorandoLetrasMaiusculasEMinusculas() {
        Pessoa pessoa1 = pessoaRepository.save(pessoaPreenchida());
        Pessoa pessoa2 = pessoaRepository.save(pessoaPreenchida2());
        List<Pessoa> pessoaList = pessoaRepository.findByNomeIgnoreCaseContaining("nome");
        System.out.println("test");
        //verificar com mais calma depois
        assertThat(pessoaList.size()).isEqualTo(3);
    }

    @Test
    public void criarPessoa() {
        Pessoa pessoaSalva = pessoaRepository.save(pessoaPreenchida());
        assertThat(pessoaSalva.getNome()).isNotNull();
        assertThat(pessoaSalva.getCpf()).isNotNull();
        assertThat(pessoaSalva.getDataNascimento()).isNotNull();
        assertThat(pessoaSalva.getTelefone()).isNotNull();
        assertThat(pessoaSalva.getId()).isNotNull();
        System.out.println("Pessoa: " + pessoaRepository.findOne(pessoaSalva.getId()));
    }

    @Test
    public void listarPessoa() {
        List<Pessoa> pessoas = this.pessoaRepository.findAll();
        assertThat(pessoas.size()).isNotNull();
        System.out.println("Tamanho: " + pessoas.size());
    }

    @Test
    public void buscarPeloCodigo() {
        Pessoa pessoaSalva = pessoaRepository.save(pessoaPreenchida());
        assertThat(pessoaService.buscarPessoaPorId(pessoaSalva.getId())).isNotNull();
        System.out.println("Id: " + pessoaSalva.getId());
    }

    @Test
    public void atualizarPessoas() {
        Pessoa pessoaSalva = pessoaRepository.save(pessoaPreenchida());
        pessoaSalva.setNome("Teste2");
        pessoaSalva.setCpf("Teste2");
        pessoaSalva.setDataNascimento("Teste");
        pessoaSalva.setTelefone("Teste");
        pessoaSalva = this.pessoaRepository.save(pessoaSalva);
        pessoaSalva = this.pessoaRepository.findOne(pessoaSalva.getId());
        assertThat(pessoaSalva.getNome()).isEqualTo("Teste2");
        assertThat(pessoaSalva.getCpf()).isEqualTo("Teste2");
        assertThat(pessoaSalva.getDataNascimento()).isEqualTo("Teste");
        assertThat(pessoaSalva.getTelefone()).isEqualTo("Teste");
    }

    @Test
    public void removerPessoas() {
        Pessoa pessoaSalvo = pessoaRepository.save(pessoaPreenchida());
        pessoaRepository.delete(pessoaSalvo);
        assertThat(pessoaService.buscarPessoaPorId(pessoaSalvo.getId())).isNull();
    }



    @Test
    public void naoDeveDeixarPersistirComNomeNulo() {
        erroEsperado.expect(DataIntegrityViolationException.class);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(null);
        pessoa.setCpf("03965478924");
        pessoa.setDataNascimento("teste");
        pessoa.setTelefone("62992412741");
        pessoaRepository.save(pessoa);
    }

    @Test
    public void naoDeveDeixarPersistirComCpfNulo() {
        erroEsperado.expect(DataIntegrityViolationException.class);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste Nome");
        pessoa.setCpf(null);
        pessoa.setDataNascimento("23/03/1994");
        pessoa.setTelefone("62992412741");
        pessoaRepository.save(pessoa);

    }

    @Test
    public void naoDeveDeixarPersistirComDataDeNascimentoNulo() {
        erroEsperado.expect(DataIntegrityViolationException.class);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste Nome");
        pessoa.setCpf("03964879126");
        pessoa.setDataNascimento(null);
        pessoa.setTelefone("62992412741");
        pessoaRepository.save(pessoa);

    }

    @Test
    public void naoDeveDeixarPersistirComTelefoneNulo() {
        erroEsperado.expect(DataIntegrityViolationException.class);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste Nome");
        pessoa.setCpf("03964879126");
        pessoa.setDataNascimento("23/03/1994");
        pessoa.setTelefone(null);
        pessoaRepository.save(pessoa);
    }

    @Test
    public void naoDeveDeixarPersistirPessoaNula() {
        erroEsperado.expect(DataIntegrityViolationException.class);
        Pessoa pessoa = new Pessoa();
        pessoaRepository.save(pessoa);
    }

}
