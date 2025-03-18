package es.upm.miw.iwvg_devops.code;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class Searches {

        public Searches() {

        }

        public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
                return new UsersDatabase().findAll()
                                .filter(user -> userName.equals(user.getName()))
                                .map(User::getFamilyName)
                                .distinct();
        }

        public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
                return new UsersDatabase().findAll()
                                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                                .flatMap(user -> user.getFractions().stream())
                                .map(Fraction::getNumerator);
        }

        public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
                return new UsersDatabase().findAll()
                                .filter(user -> user.getFractions().stream()
                                                .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                                .map(User::getFamilyName);
        }

        public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
                return new UsersDatabase().findAll()
                                .filter(user -> user.getFractions().stream()
                                                .anyMatch(Fraction::isProper))
                                .map(User::initials);
        }

        public Stream<String> findUserIdByAnyProperFraction() {
                return new UsersDatabase().findAll()
                                .filter(user -> user.getFractions().stream()
                                                .anyMatch(Fraction::isProper))
                                .map(User::getId);
        }

        public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {
                return new UsersDatabase().findAll()
                                .filter(user -> user.getFamilyName().equals(familyName))
                                .flatMap(user -> user.getFractions().stream())
                                .reduce(new Fraction(1, 1), (subtotal, item) -> Fraction.multiplay(subtotal, item));

        }

}
