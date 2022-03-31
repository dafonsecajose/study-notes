package br.com.dio.bootcamp.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String name;
    private Set<Content> inscribedContents = new LinkedHashSet<>();
    private Set<Content> completedContents = new LinkedHashSet<>();

    public void registerBootcamp(Bootcamp bootcamp){
        this.inscribedContents.addAll(bootcamp.getContents());
        bootcamp.getRegisteredDevs().add(this);
    }

    public void toProgress() {
        Optional<Content> content = this.inscribedContents.stream().findFirst();
        if(content.isPresent()) {
            this.completedContents.add(content.get());
            this.inscribedContents.remove(content.get());
        } else {
            System.out.println("Você não está inscrito em nenhum conteudo!");
        }
    }

    public double calculateTotalXp() {
        return this.completedContents
                .stream()
                .mapToDouble(Content::calculateXp)
                .sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getInscribedContents() {
        return inscribedContents;
    }

    public void setInscribedContents(Set<Content> inscribedContents) {
        this.inscribedContents = inscribedContents;
    }

    public Set<Content> getCompletedContents() {
        return completedContents;
    }

    public void setCompletedContents(Set<Content> completedContents) {
        this.completedContents = completedContents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(inscribedContents, dev.inscribedContents) && Objects.equals(completedContents, dev.completedContents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inscribedContents, completedContents);
    }
}
