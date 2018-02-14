/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011-2018 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.sleuthkit.autopsy.corecomponentinterfaces.DataSourceProcessor;
import org.sleuthkit.autopsy.coreutils.Logger;

@Messages({
    "LogicalFilesDspPanel.subTypeComboBox.localFilesOption.text=Local files and folders",
    "LogicalFilesDspPanel.subTypeComboBox.l01FileOption.text=Logical evidence file (L01)"
})
/**
 * Add input wizard subpanel for adding local files / dirs to the case
 */
final class LogicalFilesDspPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private static LocalFilesPanel localFilesPanel = new LocalFilesPanel();
    private static LogicalEvidenceFilePanel l01panel = LogicalEvidenceFilePanel.createInstance();
    private static LogicalFilesDspPanel instance;
    private static final Logger logger = Logger.getLogger(LogicalFilesDspPanel.class.getName());

    /**
     * Creates new form LocalFilesPanel
     */
    private LogicalFilesDspPanel() {
        initComponents();
        dspSubtypePanel.setLayout(new BoxLayout(dspSubtypePanel, BoxLayout.Y_AXIS));
        dspSubtypePanel.add(l01panel);
        dspSubtypePanel.add(localFilesPanel);
        l01panel.setVisible(false);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        localFilesPanel.addPropertyChangeListener(listener);
        l01panel.addPropertyChangeListener(listener); 
    }
    @Override
     public void removePropertyChangeListener(PropertyChangeListener listener) {
        super.removePropertyChangeListener(listener);
        localFilesPanel.removePropertyChangeListener(listener);
        l01panel.removePropertyChangeListener(listener); 
     }
    
    static synchronized LogicalFilesDspPanel getDefault() {
        if (instance == null) {
            instance = new LogicalFilesDspPanel();
        }
        return instance;
    }

    String getContentType() {
        return NbBundle.getMessage(this.getClass(), "LocalFilesPanel.contentType.text");
    }

    void select() {
        dspSubtypeComboBox.setSelectedIndex(0);
        localFilesPanel.setVisible(true);
        l01panel.setVisible(false);
        localFilesPanel.reset();
        l01panel.reset();
        dspSubtypePanel.repaint();
    }

    @Override
    public String toString() {
        return NbBundle.getMessage(this.getClass(), "LocalFilesDSProcessor.toString.text");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dspSubtypePanel = new javax.swing.JPanel();
        dspSubtypeComboBox = new javax.swing.JComboBox<>();

        dspSubtypePanel.setPreferredSize(new java.awt.Dimension(467, 160));

        javax.swing.GroupLayout dspSubtypePanelLayout = new javax.swing.GroupLayout(dspSubtypePanel);
        dspSubtypePanel.setLayout(dspSubtypePanelLayout);
        dspSubtypePanelLayout.setHorizontalGroup(
            dspSubtypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );
        dspSubtypePanelLayout.setVerticalGroup(
            dspSubtypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        dspSubtypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text(), Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text()}));
        dspSubtypeComboBox.setMinimumSize(new java.awt.Dimension(379, 20));
        dspSubtypeComboBox.setPreferredSize(new java.awt.Dimension(379, 20));
        dspSubtypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dspSubtypeComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dspSubtypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dspSubtypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dspSubtypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dspSubtypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dspSubtypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dspSubtypeComboBoxActionPerformed
        if (evt.getSource() instanceof JComboBox<?>) {
            JComboBox<?> cb = (JComboBox<?>) evt.getSource();
            String selectedSubType = dspSubtypeComboBox.getSelectedItem().toString();
            if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text())) {
                localFilesPanel.setVisible(true);
                l01panel.setVisible(false);
            } else if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text())) {
                localFilesPanel.setVisible(false);
                l01panel.setVisible(true);
            }
            firePropertyChange(DataSourceProcessor.DSP_PANEL_EVENT.UPDATE_UI.toString(), false, true);
        }
    }//GEN-LAST:event_dspSubtypeComboBoxActionPerformed

    /**
     * Validate the contents of the panel and its subtype.
     * 
     * @return true if the panel is valid, false if it is not
     */
    boolean validatePanel() {
        // display warning if there is one (but don't disable "next" button)

        String selectedSubType = dspSubtypeComboBox.getSelectedItem().toString();
        if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text())) {
            return localFilesPanel.validatePanel();
        } else if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text())) {
            return l01panel.validatePanel();
        } else {
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dspSubtypeComboBox;
    private javax.swing.JPanel dspSubtypePanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Identify if the selected subtype panel is a LogicalEvidencePanel
     * 
     * @return true if logical evidence files have been selected
     */
    boolean subTypeIsLogicalEvidencePanel() {
        String selectedSubType = dspSubtypeComboBox.getSelectedItem().toString();
        return selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text());
    }

    /**
     * Get the selected paths of the selected panel subtype.
     * 
     * @return a list of strings which are paths to the selected files or directories
     */
    List<String> getContentPaths() {
        String selectedSubType = dspSubtypeComboBox.getSelectedItem().toString();
        if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text())) {
            return localFilesPanel.getContentPaths();
        } else if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text())) {
            return l01panel.getContentPaths();
        } else {
            return new ArrayList<>();
        }

    }

    /**
     * Get the name of the file set based on its subtype.
     * 
     * @return the name of the set of files to be ingested.
     */
    String getFileSetName() {
        String selectedSubType = dspSubtypeComboBox.getSelectedItem().toString();
        if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_localFilesOption_text())) {
            return localFilesPanel.getFileSetName();
        } else if (selectedSubType.equals(Bundle.LogicalFilesDspPanel_subTypeComboBox_l01FileOption_text())) {
            return l01panel.getFileSetName();
        } else {
            return "";
        }
    }
}
