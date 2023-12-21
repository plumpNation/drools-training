package io.github.plumpnation.drools;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import io.github.aasaru.drools.Common;
import io.github.aasaru.drools.domain.Passport;
import io.github.aasaru.drools.repository.ApplicationRepository;

public class Main {
  public static void main(final String[] args) {
    execute();
  }

  static void execute() {
    KieSession ksession = KieServices.Factory.get().getKieClasspathContainer().newKieSession("PlumpNationSession1");

    List<Passport> passports = ApplicationRepository.getPassports();

    passports.forEach(ksession::insert);

    ksession.fireAllRules();

    if (Common.disposeSession) {
      ksession.dispose();
    }
  }
}
