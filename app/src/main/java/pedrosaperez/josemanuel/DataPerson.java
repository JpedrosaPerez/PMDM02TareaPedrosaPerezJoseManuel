package pedrosaperez.josemanuel;

/**
 * Representa un personaje del videojuego MarioKarts con información básica como su imagen, nombre, descripción y habilidades.
 *
 *
 * @author [Jose Manuel Pedrosa Perez]
 * @version 1.0
 */
public class DataPerson {

    /** El identificador de recurso de la imagen del personaje. */
    private final int image;

    /** El nombre del personaje. */
    private final String name;

    /** Una breve descripción del personaje. */
    private final String description;

    /** Las habilidades o atributos únicos del personaje. */
    private final String skills;

    /**
     * Construye un nuevo objeto DataPerson que representa un personaje de videojuego.
     *
     * @param image El identificador de recurso de la imagen del personaje.
     * @param name El nombre del personaje.
     * @param description Una breve descripción del personaje.
     * @param skills Las habilidades o atributos únicos del personaje.
     */
    public DataPerson(int image, String name, String description, String skills) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skills = skills;
    }

    /**
     * Obtiene el identificador de recurso de la imagen del personaje.
     *
     * @return El identificador de recurso de la imagen.
     */
    public int getImage() {
        return image;
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return El nombre del personaje.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene una breve descripción del personaje.
     *
     * @return La descripción del personaje.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene las habilidades o atributos únicos del personaje.
     *
     * @return Las habilidades del personaje.
     */
    public String getSkills() {
        return skills;
    }
}
