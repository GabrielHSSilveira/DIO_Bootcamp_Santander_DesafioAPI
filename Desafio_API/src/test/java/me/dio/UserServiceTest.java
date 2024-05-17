package me.dio;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        // Simular comportamento do repositório
        List<User> users = Arrays.asList(new User(1L, "User1"), new User(2L, "User2"));
        Mockito.when(userRepository.findAll()).thenReturn(users);

        // Chamar o método a ser testado
        List<User> result = userService.findAll();

        // Verificar se o resultado é o esperado
        assertEquals(users.size(), result.size());
    }

}