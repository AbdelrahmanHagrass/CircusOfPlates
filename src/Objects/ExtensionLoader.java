package Objects;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ExtensionLoader<C> {

  public Plate LoadClass(String directory, String classpath, Class<Plate> parentClass) throws ClassNotFoundException {
    File pluginsDir = new File(System.getProperty("user.dir") + directory);
    for (File jar : pluginsDir.listFiles()) {
      try {
        ClassLoader loader = URLClassLoader.newInstance(
            new URL[] { jar.toURL() },
            getClass().getClassLoader()
        );
        Class<?> clazz = Class.forName(classpath, true, loader);
        Class<? extends Plate> newClass = clazz.asSubclass(parentClass);
        // Apparently its bad to use Class.newInstance, so we use 
        // newClass.getConstructor() instead
        Constructor<? extends Plate> constructor = newClass.getConstructor();
        System.out.println(clazz.getName());
        return constructor.newInstance();
        
      } catch (ClassNotFoundException e) {
        // There might be multiple JARs in the directory,
        // so keep looking
        continue;
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InstantiationException e) {
        e.printStackTrace();
      }
    }
    throw new ClassNotFoundException("Class " + classpath
        + " wasn't found in directory " + System.getProperty("user.dir") + directory);
  }
}