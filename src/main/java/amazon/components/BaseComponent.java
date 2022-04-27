package amazon.components;

import amazon.utils.AmazonDriver;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/***
 * We will declare / implement reusable methods and variables across multiple components
 */

public abstract class BaseComponent implements IComponent {
    final Logger logger = Logger.getLogger(this.getClass());
    AmazonDriver driver;
    ResourceBundle bundle;
}
