import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class test {

    interface Structure {
        // zwraca dowolny element o podanym kolorze
        Optional<Block> findBlockByColor(String color);

        // zwraca wszystkie elementy z danego materiału
        List<Block> findBlocksByMaterial(String material);

        //zwraca liczbę wszystkich elementów tworzących strukturę
        int count();
    }

    public class Wall implements Structure, CompositeBlock {
        public List<Block> blocks;

        public Wall(List<Block> blocks) {
            this.blocks = blocks;
        }


        @Override
        public Optional<Block> findBlockByColor(String color) {
            return blocks.stream().filter(b -> b.getColor().equals(color)).findAny();
        }

        @Override
        public List<Block> findBlocksByMaterial(String material) {
            return blocks.stream().filter(b -> b.getMaterial().equals(material)).collect(Collectors.toList());
        }

        @Override
        public int count() {
            return blocks.size();
        }

        @Override
        public String getColor() {
            return null;
        }

        @Override
        public String getMaterial() {
            return null;
        }

        @Override
        public List<Block> getBlocks() {
            return blocks;
        }


    }

    interface Block {
        String getColor();
        String getMaterial();
    }

    interface CompositeBlock extends Block {
        List<Block> getBlocks();
    }
}
