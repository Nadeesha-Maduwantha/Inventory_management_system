

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody createUserRequest request ){
        UserRespones response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).bidy(response);
        
        
    }
    
}
